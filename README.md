

1. item/create

method:POST

In:
```json5
{
    "name": "",
    "description": "",
    "price": "", 
    "isAvailable": "" 
}
```
Out
```json5
{
    result: ""
}
```
2. item/getItem/{name}

method:GET


Out
```json5
{
    "id": "",
    "name": "",
    "description": "",
    "price": "", 
    "isAvailable": "" 
}
```


3. item/update

method:POST


In:
```json5
{
    "name": "",
    "description": ""
}
```

Out
```json5
{
    result: ""
}
```

4. item/delete/{name}

method:DELETE

Out
```json5
{
    result: ""
}
```
