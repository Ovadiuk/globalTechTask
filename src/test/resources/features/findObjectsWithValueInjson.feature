Feature: find objects with value in json file

  @run
  Scenario Outline: check methos for find objects with value in json file
    When User provides Path to jsonFile "<path>"
    Then User Provides FieldName "<fieldName>" and Value "<value>" after application should be find "<result>" Objects in this json file
    Examples:
      | path                                                                        |  fieldName          |value   | result    |
      |     src/test/resources/examples/positive.json                               |   fieldForTest      |test    |  6        |
      |     src/test/resources/examples/positive.json                               |   fieldForTest      |test2   |  1        |
      |     src/test/resources/examples/positive.json                               |   fieldForTest      |notExist|  0        |
      |     src/test/resources/examples/positive.json                               |   notExist          |test    |  0        |
      |     src/test/resources/examples/positive.json                               |   notExist          |notExist|  0        |
      |     src/test/resources/examples/empty.json                                  |   notExist          |notExist|  0        |
      |     src/test/resources/examples/valuesIsEmpty.json                          |  fieldForTest       |        |  6        |
      |     src/test/resources/examples/fieldsIsEmpty.json                          |                     |test    |  6        |
      |     src/test/resources/examples/fieldNameAndValueContainsUniqueChar.json    |  fieldForTest¢      | test¢  |  6        |
      |     src/test/resources/examples/booleen.json                                |  fieldForTest       | true   |  6        |
      |     src/test/resources/examples/int.json                                    |  fieldForTest       | 1234   |  6        |