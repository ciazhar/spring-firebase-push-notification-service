# Push Notification Service
>Backend Service for Push Notification to Android Device using Firebase.
 
## Stack
- Spring Boot

## Run Project
``` bash
$ ./gradlew bootRun
```
This application will run in `localhost:8080`

## Endpoint 
1. Push Notification
`localhost:8080/send`
method  : POST
This endpoint will push notification to spesific `firebaseToken` using :
```json
{
	"to":"{{firebaseToken}}",
	"animeTitle":"",
	"username":"",
	"review":"",
	"slug":""
}
```
or `topic` using :
```json
{
	"to":"/topics/{{topicName}}",
	"animeTitle":"",
	"username":"",
	"review":"",
	"slug":""
}
```
and this endpoint will POST to "https://fcm.googleapis.com/fcm/send" attaching `FIREBASE_SERVER_KEY` and json like :
```
{
	"to":"",
	"priority":"",
	"notification":[
	    "title":"",
	    "body":""
	],
	"data":[
	    "data1":"",
	    "data2":""
	]
}
```