# blackjack_java

Fork this code to work with java in workshop 3. This repo only contains java files.

Changes made : 

Implemented stand according to sequence diagram.
Added Winstrategy as a rule. Added softSeventeen hit Strategy. Added advantage to either player or dealer Strategy.
Removed dupliacte and added a new method to handle it called getShowDeal(). In the class RuleFactory you can change 
which rule you want to play with by returning that strategy. The code pushed now has currently set : 

Hitrule : SoftSeventeen 
(Optional Hitrules : Basic hit)

Gamerule : American
(Optional Gamerules : International)

Winrule : AdvantagePlayer
(Optional Winrules : Advantage dealer)