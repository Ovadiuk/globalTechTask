Feature: find objects with value in json file

  @run
  Scenario Outline: check methos for find objects with value in json file
    When User provides Path to jsonFile "<path>"
    Then User Provides FieldName "<fieldName>" and Value "<value>" after application should be find "<result>" Objects in this json file
    Examples:
      | path                                                                        |  fieldName          |value   | result    |
      |     src/test/resources/examples/positive.json                               |   fieldForTest      |test    |  2        |
      |     src/test/resources/examples/positive.json                               |   fieldForTest      |notExist|  0        |
      |     src/test/resources/examples/positive.json                               |   notExist          |test    |  0        |
      |     src/test/resources/examples/positive.json                               |   notExist          |notExist|  0        |
      |     src/test/resources/examples/empty.json                                  |   notExist          |notExist|  0        |
      |     src/test/resources/examples/positive.json                               |  fieldForTest       |        |  1        |
      |     src/test/resources/examples/positive.json                               |                     |        |  1        |
      |     src/test/resources/examples/positive.json                               |  fieldForTest¢      | test¢  |  1        |
      |     src/test/resources/examples/positive.json                               |  booleen            | true   |  1        |
      |     src/test/resources/examples/positive.json                               |  int                | 1234   |  1        |