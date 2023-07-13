# API Spec

## Authentication

All API must use this authentication

Request :
- Header :
    - X-Api-Key : "your secret api key"

## Create Team

Request :
- Method : POST
- Endpoint : `/api/teams`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
      "id" : "string, unique",
      "name" : "string",
      "firstDriver" : "string",
      "secondDriver" : "string",
      "teamEntry": "string",
      "champion":  "integer"
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "name" : "string",
         "firstDriver" : "string",
         "secondDriver" : "string",
         "teamEntry": "string",
         "champion":  "integer",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## Get Team

Request :
- Method : GET
- Endpoint : `/api/teams/{id_team}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique", 
         "name" : "string",
         "firstDriver" : "string",
         "secondDriver" : "string",
         "teamEntry": "string",
         "champion":  "integer",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## Update Team

Request :
- Method : PUT
- Endpoint : `/api/teams/{id_team}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
    "name" : "string",
    "firstDriver" : "string",
    "secondDriver" : "string",
    "teamEntry": "string",
    "champion":  "integer"
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
        "id" : "string, unique",
        "name" : "string",
        "firstDriver" : "string",
        "secondDriver" : "string",
        "teamEntry": "string",
        "champion":  "integer",
        "createdAt" : "date",
        "updatedAt" : "date"
     }
}
```

## List Teams

Request :
- Method : GET
- Endpoint : `/api/teams`
- Header :
    - Accept: application/json
- Query Param :
    - size : number,
    - page : number

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : [
        {
            "id" : "string, unique",
            "name" : "string",
            "firstDriver" : "string",
            "secondDriver" : "string",
            "teamEntry": "string",
            "champion":  "integer",
            "createdAt" : "date",
            "updatedAt" : "date"
        },
        {
            "id" : "string, unique",
            "name" : "string",
            "firstDriver" : "string",
            "secondDriver" : "string",
            "teamEntry": "string",
            "champion":  "integer",
            "createdAt" : "date",
            "updatedAt" : "date"
         }
    ]
}
```

## Delete Team

Request :
- Method : DELETE
- Endpoint : `/api/teams/{id_team}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string"
}
```