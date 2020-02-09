[1] PLAYLIST 생성  
-
POST /playList/make  
content-type : form-data

|Parameter|Type|Descrption|
|---------|----|---------|
|userId|int|(필수)사용자 아이디|
|title|String|(필수)플레이리스트 제목|



Response Body  

 없음

[2] PLAYLIST 노래,앨범 추가 
-
POST /playlist/add  
content-type : form-data  

|Parameter|Type|Descrption|
|---------|----|---------|
|songId|long|(필수)노래/앨법 아이디|
|isAlbum|boolean|(필수)추가할 항목이 앨범이면 true, 노래이면 false|
|playListId|long|(필수)플레이 리스트 아이디|

Response Body  

 없음    
   
  

[3] PLAYLIST 목록 
-
GET /playlist/{uid}

|Parameter|Type|Descrption|
|---------|----|---------|
|uid|int|(필수)사용자 아이디|

Response Body  

 ```json
[
  {
    "id": 1,
    "userId": 1,
    "songs": [
      {
        "id": 1,
        "title": "Please Please Me (1963.3) song-1",
        "length": 224,
        "track": 1,
        "albumId": 1
      },
      {
        "id": 2,
        "title": "Please Please Me (1963.3) song-2",
        "length": 454,
        "track": 2,
        "albumId": 1
      },
      {
        "id": 3,
        "title": "Please Please Me (1963.3) song-3",
        "length": 455,
        "track": 3,
        "albumId": 1
      },
      {
        "id": 4,
        "title": "Please Please Me (1963.3) song-4",
        "length": 299,
        "track": 4,
        "albumId": 1
      },
      {
        "id": 5,
        "title": "Please Please Me (1963.3) song-5",
        "length": 142,
        "track": 5,
        "albumId": 1
      },
      {
        "id": 6,
        "title": "Please Please Me (1963.3) song-6",
        "length": 367,
        "track": 6,
        "albumId": 1
      },
      {
        "id": 7,
        "title": "Please Please Me (1963.3) song-7",
        "length": 438,
        "track": 7,
        "albumId": 1
      },
      {
        "id": 8,
        "title": "Please Please Me (1963.3) song-8",
        "length": 439,
        "track": 8,
        "albumId": 1
      },
      {
        "id": 9,
        "title": "Please Please Me (1963.3) song-9",
        "length": 313,
        "track": 9,
        "albumId": 1
      },
      {
        "id": 10,
        "title": "Please Please Me (1963.3) song-10",
        "length": 369,
        "track": 10,
        "albumId": 1
      },
      {
        "id": 11,
        "title": "Please Please Me (1963.3) song-11",
        "length": 190,
        "track": 11,
        "albumId": 1
      }
    ],
    "title": "123"
  }
]
 ```

[4] PLAYLIST 삭제 
-
DELETE /playlist/del/{id}


|Parameter|Type|Descrption|
|---------|----|---------|
|id|long|(필수)플레이 리스트 id|

Response Body  

 없음

