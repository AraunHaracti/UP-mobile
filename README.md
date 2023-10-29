# Work with Database in android

## About

> [!NOTE]
> Actors information.

## Task

1. Create ER-diagram
2. Create entities, daos and database in project
3.

## ER-diagram

```mermaid
erDiagram

Genre {
  int Id PK
  string Name
}

Country {
  int Id PK
  string Name 
}

Reward {
  int Id PK
  string Name
  date Date
  string Info
} 

Actor {
  int Id PK
  int CountryId FK
  string Name
  string Surname
  date Birthday
}

Film {
  int Id PK
  int GenreId FK
  int CountryId FK
  string Name
  date Date
}

ActorInFilm {
  int Id PK
  int ActorId FK
  int FilmId FK
  string Role
  string AboutRole
}

RewardForActor {
  int Id PK
  int ActorId FK
  int RewardId FK
}	

Genre ||--|{ Film : "has"
Country ||--|{ Film : "removed"
Country ||--|{ Actor : "from"
Film ||--|{ ActorInFilm : "contains"
Actor ||--|{ ActorInFilm : "consists of"
Actor ||--|{ RewardForActor : "has"
Reward ||--|{ RewardForActor : "has"
```
### [Er-diagram in dbdesign.io](https://dbdiagram.io/d/fot-mobile-project-65322f7dffbf5169f0165d7d)
