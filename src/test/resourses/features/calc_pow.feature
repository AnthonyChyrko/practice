Feature: Calculator_pow

Scenario Outline: Pow of the two numbers
Given two numbers like <a> and <b>
When we try to find pow of our numbers
Then result should be a <result>

Examples:
| a | b | result  |
| 3 | 2 | 6       |
| 1 | 2 | 2       |