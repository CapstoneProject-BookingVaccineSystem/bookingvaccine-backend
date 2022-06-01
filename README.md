# API Spec
## Authentication
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
