primenumber-calculator-service
======================

Pre-requisites
-------------

Install

- JDK 1.8
- Maven 3 (or higher)
- Tomcat 7


Purpose
-------
To find out the prime numbers for the end range specified. It will also validate if the given number is prime or not.

Technology stack
----------
Jersey
Spring
Logback
Mockito



Rest (OPEN) API
----------------
Resource Information

Response formats   JSON
Requires authentication?  No
Rate limited? No


Example Request for populating the list of prime numbers
--------
GET
http://localhost:8085/primeNumber/calculate/19

Example Result
--------------
{"Prime Numbers":[2,3,5,7,11,13,17,19]}


Example Request for validating the number
--------
GET
http://localhost:8085/primeNumber/verify/19

Example Result
--------------
{"result":true}

