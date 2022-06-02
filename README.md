# API Spec
## 1. Authentication Login
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
## 1.1 Authentication Register
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
## 2. Dashboard
### Total Data Admin
Request
- Method: GET
- Endpoint : `/api/v1/dashboard/admin`
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
        "id_admin": "200"
    }
}
```
### Total Data User
Request
- Method: GET
- Endpoint : `/api/v1/dashboard/user`
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
        "id_user": "200"
    }
}
```
### Total Data Area (Kelurahan)
Request
- Method: GET
- Endpoint : `/api/v1/dashboard/area`
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
        "id_area": "4"
    }
}
```
### Total Data RSUD
Request
- Method: GET
- Endpoint : `/api/v1/dashboard/category/rsud`
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
        "id_category_facilities": "4"
    }
}
```
### Total Data Puskesmas
Request
- Method: GET
- Endpoint : `/api/v1/dashboard/category/puskesmas`
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
        "id_category_facilities": "16"
    }
}
```
