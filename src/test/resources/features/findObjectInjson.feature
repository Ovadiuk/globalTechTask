Feature: find objects in json file

  @run
  Scenario Outline: check methos for find objects in json file
    When User provides Path to jsonFile "<path>"
    Then User Provides FieldName "<fieldName>" after application should be find "<result>" Objects in this json file
    Examples:
      |      path                                                             |   fieldName     | result  |
      |   src/test/resources/examples/positive.json                           |   fieldForTest  |  7      |
      |   src/test/resources/examples/positive.json                           |   notExist      |  0      |
      |   src/test/resources/examples/empty.json                              |   notExist      |  0      |
      |   src/test/resources/examples/valuesIsEmpty.json                      |   fieldForTest  |  7      |
      |   src/test/resources/examples/fieldNameAndValueContainsUniqueChar.json|   fieldForTest¢ |  7      |
      |   src/test/resources/examples/fieldsIsEmpty.json                      |                 |  7      |
      |   src/test/resources/examples/booleen.json                            |   fieldForTest  |  7      |
      |   src/test/resources/examples/int.json                                |   fieldForTest  |  7      |
