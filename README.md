# API Spec (Mobile App)
## Authentication Login Page
Request
- Method: POST
- Validation di MobileApp -> panjang string = 13 dan input = [0-9]
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
## Authentication Register Page
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
## 1.Home Page
### GET data profile
Request
- Method: GET
- Endpoint : `/api/v1/home`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
    "photo_profile":"filedata",
    "firstName":"Jose"
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        "photo_profile":"filedata",
        "firstName":"Jose"
    }
}
```
### GET data card vaccine
Request
- Method: GET
- Endpoint : `/api/v1/belumfix`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
    // belum fix
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        // belum fix
    }
}
```
### GET data article Id 1
Request
- Method: GET
- Endpoint : `/api/v1/belumfix`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
    // belum fix
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        // belum fix
    }
}
```
### GET data article Id 2
Request
- Method: GET
- Endpoint : `/api/v1/belumfix`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
    // belum fix
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        // belum fix
    }
}
```
### GET data article latest
Request
- Method: GET
- Endpoint : `/api/v1/article`
- Order By : Descending
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{

}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        // show data sorted
    }
}
```
## 2. Profile Page
### GET Data before edit
Request
- Method: GET
- Endpoint : `/api/v1/auth/users/edit/id`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
  // id
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        "photo_profile":"filedata",
        "firstName":"Jose",
        "lastName":"Mourinho",
        "birthDate": "1980-12-10",
        "gender":"Laki-laki",
        "email":"test@test.com",
        "password":"passwordAdmin",
        "username":"1871654852548",
        "noHandphone":"0721548484"
    }
}
```
### Update Data
Request
- Method: PUT
- Endpoint : `/api/v1/auth/users/edit/id`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
    "photo_profile":"filedata",
    "firstName":"Jose",
    "lastName":"Mourinho",
    "birthDate": "1980-12-10",
    "gender":"Laki-laki",
    "email":"test@test.com",
    "password":"passwordAdmin",
    "username":"1871654852548",
    "noHandphone":"0721548484"
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        "photo_profile":"filedata",
        "firstName":"Jose",
        "lastName":"Mourinho",
        "birthDate": "1980-12-10",
        "gender":"Laki-laki",
        "email":"test@test.com",
        "password":"passwordAdmin",
        "username":"1871654852548",
        "noHandphone":"0721548484"
    }
}
```
## 3. Member Family page
### Create Data
Request
- Method: POST
- Endpoint : `/api/v1/auth/users/edit/id`
- Validation : string length = 13 & string = [0-9]
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
  "nik":"1871xxxxxxxxx",
  "fullname":"Steve Jobs"
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        "nik":"1871xxxxxxxxx",
        "fullname":"Steve Jobs"
    }
}
```
## 4. Booking page (1)
### GET ALL Data Area
Request
- Method: GET
- Endpoint : `/api/v1/auth/area`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
  
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
        // show all data area
    }
}
```
## 4. Booking page (2)
### GET Data Session Vaccine By Id Area
Request
- Method: GET
- Endpoint : `/api/v1/facility/area?id_area=1`
- Header : 
  - Content-Type: application/json
  - Accept: application/json
- body
```
{
  
}
```
Response
```
{
    "timestamp": "01-06-2022 23:13:45",
    "message": "Success!",
    "data": {
       "name_health_facilities":"Puskemas Manjur",
       "telp_facilites":"021-454 454",
       "address_health_facilities":"Jl Bungur",
       "stock": 100
       "start_time": "08.00",
       "end_time": "10.00",
    }
}
```
