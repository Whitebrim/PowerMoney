package dev.aura.powermoney.network.packet.clientbound;

import dev.aura.powermoney.client.gui.GuiPowerReceiver;
import dev.aura.powermoney.common.payment.SpongeMoneyInterface;
import dev.aura.powermoney.network.helper.SerializationHelper;
import io.netty.buffer.ByteBuf;
import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

@EqualsAndHashCode
public class PacketSendReceiverData implements IMessage {
  private long localEnergy;
  private long totalEnergy;
  private BigDecimal money;
  private String moneySymbol;
  private int defaultDigits;

  public PacketSendReceiverData() {}

  public PacketSendReceiverData(Long localEnergy, Long totalEnergy, BigDecimal money) {
    this.localEnergy = (localEnergy == null) ? 0L : localEnergy;
    this.totalEnergy = (totalEnergy == null) ? 0L : totalEnergy;
    this.money = (money == null) ? BigDecimal.ZERO : money;

    moneySymbol = SpongeMoneyInterface.getMoneySymbol();
    defaultDigits = SpongeMoneyInterface.getDefaultDigits();
  }

  @Override
  public void fromBytes(ByteBuf buf) {
    localEnergy = buf.readLong();
    totalEnergy = buf.readLong();
    money = SerializationHelper.readBigDecimal(buf);
    moneySymbol = ByteBufUtils.readUTF8String(buf);
    defaultDigits = buf.readInt();
  }

  @Override
  public void toBytes(ByteBuf buf) {
    buf.writeLong(localEnergy);
    buf.writeLong(totalEnergy);
    SerializationHelper.writeBigDecimal(buf, money);
    ByteBufUtils.writeUTF8String(buf, moneySymbol);
    buf.writeInt(defaultDigits);
  }

  public static class Handler extends AbstractClientMessageHandler<PacketSendReceiverData> {
    @Override
    public IMessage handleClientMessage(
        EntityPlayer player, PacketSendReceiverData message, MessageContext ctx) {
      GuiPowerReceiver.setReceiverData(
          message.localEnergy,
          message.totalEnergy,
          message.money,
          message.moneySymbol,
          message.defaultDigits);

      return null;
    }
  }
}
