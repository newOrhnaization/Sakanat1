Feature: Information for the house

  Scenario: empty information
    When user click on insert house and flag is 'true'
    Then all field should be with 'error'

  Scenario: a successful Information
    When user click on insert house and flag is 'true'
    And he fill in 'Price' with '600'
    And he fill in 'Location' with "Nablus_Rafidiya"
    And he fill in 'Services' with 'electricity,Water'
    And he fill in 'Bedroom' with '3'
    And he fill in 'Bathroom' with '2'
    And he fill in 'Balcony' with '1'
    And he fill in 'picture' with extension '.png'
    And he fill in 'housenumber' with '1101230'
    And he presses 'save' and flag is 'true'
    Then show massage 'information has been entered successfully'


  Scenario Outline: errors with input
    When user click on insert house and flag is 'true'
    And he fill in 'Price' with the '<Price>'
    And he fill in 'Location' with the '<Location>'
    And he fill in 'Services' with the '<Services>'
    And he fill in 'Bedroom' with the '<Bedroom>'
    And he fill in 'Bathroom' with the '<Bathroom>'
    And he fill in 'Balcony' with the '<Balcony>'
    And he fill in 'picture' with the extension '<picture>'
    And he fill in 'housenumber' with the '<housenumber>'
    And he presses 'save' and flag is 'true'
    Then the user should see '<message>'

    Examples:
      |Price     | Location| Services|    Bedroom   |  Bathroom    | Balcony    |   picture |housenumber    |message   |
      |0         | Tell  | electricity,water            |2            |1             |2           |png   |  11B1120       |price must be more than 0|
      |600       | Nablus_Rafidiya |electricity,water         |0            |2             |1           |png  |1101090          |Bedroom must be more than 0 |
      |600       | Nablus   |electricity,water          |2            |0             |2           |png        |1402100      |Bathroom must be more than 0 |
      |-200      | Rafidiya   |electricity,water             |2            |2             |2           |png     |1503120        |Price must  be Positive|
      |600       | Tell    |electricity,water          |-2           |1             |2           |png           | 1503120         |Bedroom must  be Positive |
      |600       | Tell    |electricity,water        |2            |-2            |2           |png             |1503120           |Bathroom  must  be Positive|
      |600       | Tell    |electricity,water         |2            |2            |-2           |png            | 1503120          |Balcony  must  be Positive|
      |600       | Tell    |electricity,water           |2            |2            |2            |exe                  |1503120           |The extension of picture should be png|
      |700         | Tell  | electricity,water            |2            |1             |2           |png   | 120       | The Number of house should be 7 bits 2 of Apartment Building number,2 of floor number, 3 for  apartment  number|
      |700         | Tell  | electricity11,water445            |2            |1             |2           |png   | 120       |services shouldnt contan integer|






