package dev.aura.powermoney.common.payment;

import com.google.common.annotations.VisibleForTesting;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import lombok.AccessLevel;
import lombok.Getter;

public abstract class MoneyCalculator {
  protected static final MathContext CALCULATION_PRECISION = MathContext.DECIMAL128;
  protected static final int RESULT_DIGITS = 4;
  protected static final RoundingMode RESULT_ROUNDING_MODE = RoundingMode.HALF_EVEN;

  protected final int calcType;

  @Getter protected final double baseMultiplier;

  @Getter(AccessLevel.NONE)
  protected final BigDecimal baseMultiplierBD;
  /**
   * = 1 / log2(logBase)<br>
   * <br>
   * This is a constant used to calculate the log of the money.<br>
   * Since we only have a log2 for BigInteger, the formula is <code>log_b(x) = log_2(x) / log_2(b)
   * </code>. So we can precalculate <code>log_2(b)</code>. And since multiplication is faster than
   * division we calculate the inverse too, so we just need to multiply it later.
   */
  @Getter(AccessLevel.NONE)
  protected final BigDecimal shiftBD;

  @Getter(AccessLevel.NONE)
  protected final BigDecimal CalcHelper;

  public MoneyCalculator(int calcType, double calcBase, double baseMultiplier, double shift) {
    this.baseMultiplier = baseMultiplier;
    this.calcType = calcType;
    shiftBD = BigDecimal.valueOf(shift);
    baseMultiplierBD = BigDecimal.valueOf(baseMultiplier);

    if (calcType == 0) {
      CalcHelper =
          BigDecimal.ONE.divide(
              BigDecimal.valueOf(Math.log(calcBase) / Math.log(2.0)), CALCULATION_PRECISION);
    } else {
      CalcHelper = BigDecimal.valueOf(calcBase);
    }
  }

  public abstract BigDecimal covertEnergyToMoney(long energy);

  @VisibleForTesting
  static BigDecimal roundResult(BigDecimal val) {
    return val.setScale(RESULT_DIGITS, RESULT_ROUNDING_MODE);
  }
}
