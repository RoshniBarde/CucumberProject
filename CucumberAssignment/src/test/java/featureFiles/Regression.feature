#Author: Roshni Barde
# The below examples for validating the status for step 1 and step 4 in the Acceptance Criteria document
@Regression
Feature: Validate the RatesAPI are fit for the purpose in the use of the exchange rate for financial reasons

  Scenario Outline: To validate the success status code of the response
    Given RatesAPI for Foreign currency exchange rates is up and running
    When user hits the RatesAPI with endpoint as "<endpoint>"
    Then RatesAPI returns the success status code as <status>

    Examples: 
      | endpoint                         | status |
      | /latest                          |    200 |
      | /latest?symbols=HKD,GBP          |    200 |
      | /latest?base=HKD                 |    200 |
      | /latest?base=HKD&symbols=GBP     |    200 |
      | /2010-01-12                      |    200 |
      | /2010-01-12?symbols=HKD,GBP      |    200 |
      | /2010-01-12?base=HKD             |    200 |
      | /2010-01-12?base=HKD&symbols=GBP |    200 |

  @Regression
  Scenario Outline: To validate the correct response based on the basevalue
    Given RatesAPI for Foreign currency exchange rates is up and running
    When user hits the RatesAPI with endpoint as "<baseEndpoint>"
    Then base value should be <baseValue>

    Examples: 
      | baseEndpoint     | baseValue |
      | /latest?base=HKD | "HKD"     |
      | /latest?base=IDR | "IDR"     |
      | /latest?base=INR | "INR"     |
      | /latest?base=DKK | "DKK"     |
