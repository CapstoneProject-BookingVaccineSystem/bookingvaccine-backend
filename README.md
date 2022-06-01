# API Spec
## Authentication Login
Request
- Method: POST
- Endpoint : `/api/v1/auth/login`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
    "nik":"1871000000021",
    "password":"123456"
}
```
Response
```
{
    "timestamp": "01-06-2022 21:26:33",
    "message": "Success!",
    "data": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJwY_Zs"
    }
}
```
## Authentication Register
Request
- Method: POST
- Endpoint : `/api/v1/auth/register`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
    "username":"1871654852548",
    "password":"passwordAdmin",
    "firstName":"Jose",
    "lastName":"Mourinho",
    "birthDate": "1980-12-10",
    "gender":"Laki-laki",
    "email":"test@test.com",
    "noHandphone":"0721548484",
    "roles":"USER"
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        "username": "1871654852548",
        "password": "passwordAdmin",
        "firstName": "Jose",
        "lastName": "Mourinho",
        "birthDate": "1980-12-10",
        "gender": "Laki-laki",
        "email": "test@test.com",
        "noHandphone": "0721548484",
        "roles": "USER"
    }
}
```
