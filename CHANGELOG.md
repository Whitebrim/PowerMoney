Version 1.4.3
-------------

\* Fixed opening the Easter Egg crashing the server for real this time (Fixes [#5](https://github.com/AuraDevelopmentTeam/PowerMoney/issues/5) and
  [#6](https://github.com/AuraDevelopmentTeam/PowerMoney/issues/6)).  


Version 1.4.2
-------------

\* ~~Fixed opening the Easter Egg crashing the server (Fixes [#5](https://github.com/AuraDevelopmentTeam/PowerMoney/issues/5)).~~  


Version 1.4.1
-------------

\+ No Easter Eggs added.  
\* Internal optimizations.  


Version 1.4.0
-------------

\* Internal improvements that should significantly improve performance (Changed `BigInteger` to `long`).  
\* Removed all `...String` methods from the CC and OC interface, since they are no longer needed.  
\* PowerReceiver now has a limit of 9,223,372,036,854,775,807 FE/s/player.  


Version 1.3.2
-------------

\+ cdcp998: Added zh_CN.lang (This time for real).  


Version 1.3.1
-------------

\+ ~~cdcp998: Added zh_CN.lang (Didn't work).~~  
\* Fixed some missing metadata.  


Version 1.3.0
-------------

\+ Added OpenComputers support.  
\* Fixed issues with CC and OC integration that when the energy was 0 the methods would just return an error.  
\* Fixed an issue where the CC and OC method `calculateEarnings` would only accept a string instead of a string and an integer.  
\* Slight improvements to CC and OC errors messages.  


Version 1.2.0
-------------

\+ Added a field for the energy consumption of the current block in the GUI.  
\+ Made that value accessible through the CC peripheral.  
\+ Added a method to simulate the earnings for any given energy value.  
\* Fixed meta files.   


Version 1.1.1
-------------

\* Fixed automatic release.  
\* Fixed several SpotBugs warnings.   


Version 1.1.0
-------------

\+ Added ComputerCraft support.  
\+ Added the PowerReceiver as an peripheral of ComputerCraft.  
\* Fixed Tesla support.  


Version 1.0.1
-------------

\+ Added Tesla support.  


Version 1.0.0
-------------

\+ Added PowerReceiver with GUI, textures and recipe.  
\+ Added energy consuming functionality to the PowerReceiver.  
\+ Implemented interface to Sponge so that the generated money can be assigned to the player.  
\+ Added basic config.  


Version 0.0.0
-------------

\* Initial commit  
