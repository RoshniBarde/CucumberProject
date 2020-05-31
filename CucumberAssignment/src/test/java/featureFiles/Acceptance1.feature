#Author: Roshni Barde
Feature: Validate the RatesAPI are fit for the purpose in the use of the exchange rate for financial reasons

  @Acceptance
  Scenario: To validate the error message for incomplete endpoint
    Given RatesAPI for Foreign currency exchange rates is up and running
    When user hits the API with endpoint as "lates"
    Then API returns the status code as 400
    And error message is displayed as "time data 'lates' does not match format '%Y-%m-%d'"

  @Acceptance
  Scenario: To validate the response by setting the symbols parameter
    Given RatesAPI for Foreign currency exchange rates is up and running
    When user hits the API with endpoint as "/2010-01-12?symbols=HKD,GBP"
    Then Base value should be "EUR"
