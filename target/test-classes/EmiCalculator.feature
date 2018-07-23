Feature: Calculate The EMIs using EMI Caculator

@HL
Scenario Outline: scenario description
	Given  Navigate to tab "<loantab>"
	And Enter the loan Amount as "<loanAmount>"
	And Enter the loan ROI as  <loanroi>
	And Enter the loan Tenure as <loantenure>
	And Select the loan Tenure type as  "<loantenuretype>"
	When Calculate EMI
   Then EMI Should be equal to <emi>
		
		Examples:
		| loantab | loanAmount | loanroi |loantenure|loantenuretype|emi  |
		| HL      | 3000000    | 11.25   |25        |Yr            |29947.00|
		
		
		
		
		