# Assignment Requirements

Swagger arayüzünden playlist olusturulabilen, datasource'u Couchbase olan bir web servis geliştirmenizi bekliyoruz.

Kısıtlar:

  - playlist adında bir bucket olusturulmalı ve içerisinde user'ın bir playlisti için bir döküman(row) tutulmalı
  - playlist içerisinde
      id (UUID generate edilebilir örnek projedeki gibi)
      name,
      description,
      followersCount(int)
      tracks (list of track olacak)
      trackCount(int),
      userId

  - track objesi içerisinde: "name" , "length"(string) , artist(string)

Endpointler:

  - playlist create endpoint (userId  alarak playlist kaydetsin)

  - playlist findById endpoint (playlistId alarak playlist dönsün)

  - playlist findAllByUserId endpoint (verilen userId’ye ait tüm playlistleri dönsün )

  - playlist delete endpoint  (playlistId üzerinden playlisti silsin)

  - add track to playlist endpoint  (playlistId üzerinden playliste track eklesin)

  - remove track to playlist endpoint  (playlistId üzerinden playlistten track cıkartsın)
