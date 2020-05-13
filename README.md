Simple gradle java app to represent a family tree (addition and querying
based on commands entered via file)

### Usage

```bash
./gradlew clean build
 java -jar build/libs/geektrust.jar file.txt  #modify content
```

#### sample input file
```
ADD_CHILD laxmi sita Female
ADD_CHILD sita barsha Female
ADD_CHILD sita bibek Male
ADD_CHILD laxmi krisha Male
ADD_CHILD laxmi bhawana Female
GET_RELATIONSHIP laxmi daughter
GET_RELATIONSHIP barsha brother
GET_RELATIONSHIP laxmi son
GET_RELATIONSHIP rame mother
GET_RELATIONSHIP barsha Maternal-Aunt
```

### Sample output
```
CHILD_ADDITION_SUCCEEDED
CHILD_ADDITION_SUCCEEDED
CHILD_ADDITION_SUCCEEDED
CHILD_ADDITION_SUCCEEDED
sita
bibek
krisha
PERSON_NOT_FOUND
bhawana
```