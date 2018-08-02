create jar file 
gradle fatJar
jar file created in projectPath/Bild/libs

run jar file
java -jar file.jar [path to json file]/file.json [Field for search] [value for search]

example: java -jar file.jar projectPath/test.json fieldForTest test
response:
found 7 objects with field fieldForTest
found 6 where fieldForTest equals test

run test cases
gradle cucumber  
 


