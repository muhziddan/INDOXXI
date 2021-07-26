package com.ziddan.indoxxi.utils

import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.data.source.remote.response.FilmResponse
import com.ziddan.indoxxi.data.source.remote.response.TvResponse

object DataDummy {
    fun generateDummyShows(): List<ShowEntity> {

        val shows = ArrayList<ShowEntity>()

        shows.add(
            ShowEntity(
                "1",
                "The Godfather",
                9.2,
                "R",
                "2h 55min",
                "Crime, Drama",
                "24 March 1972 (USA)",
                "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.",
                "Francis Ford Coppola",
                "Mario Puzo, Francis Ford Coppola",
                "Marlon Brando, Al Pacino, James Caan",
                false,
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "2",
                "Demon Slayer: Kimetsu no Yaiba the Moview: Mugen Train",
                8.3,
                "R",
                "1h 57min",
                "Animation, Action, Adventure",
                "23 April 2021 (USA)",
                "After his family was brutally murdered and his sister turned into a demon, Tanjiro Kamado's journey as a demon slayer began. Tanjiro and his comrades embark on a new mission aboard the Mugen Train, on track to despair.",
                "Haruo Sotozaki",
                "Koyoharu Gotouge",
                "Natsuki Hanae, Akari Kitô, Yoshitsugu Matsuoka",
                false,
                "https://wallpapercave.com/wp/wp7836444.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "3",
                "The Shawshank Redemption",
                9.3,
                "R",
                "2h 22min",
                "Drama",
                "14 October 1994 (USA)",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "Frank Darabont",
                " Stephen King, Frank Darabont",
                "Tim Robbins, Morgan Freeman, Bob Gunton",
                false,
                "https://images-na.ssl-images-amazon.com/images/I/51KjbtEkoeL._AC_.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "4",
                "The Dark Knight",
                9.0,
                "PG-13",
                "2h 32min",
                "Action, Crime, Drama",
                "18 July 2008 (USA)",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                "Christopher Nolan",
                "Jonathan Nolan, Christopher Nolan",
                "Christian Bale, Heath Ledger, Aaron Eckhart",
                false,
                "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "5",
                "The Lord of the Rings: The Return of the King",
                8.9,
                "PG-13",
                "3h 21min",
                "Action, Adventure, Drama",
                "17 December 2003 (USA)",
                "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
                "Peter Jackson",
                "J.R.R. Tolkien, Fran Walsh",
                "Elijah Wood, Viggo Mortensen, Ian McKellen",
                false,
                "https://images-na.ssl-images-amazon.com/images/I/71X6YzwV0gL._AC_SL1024_.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "6",
                "The Lord of the Rings: The Fellowship of the Ring",
                8.8,
                "PG-13",
                "2h 58min",
                "Action, Adventure, Drama",
                "19 December 2001 (USA)",
                "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
                "Peter Jackson",
                "J.R.R. Tolkien, Fran Walsh",
                "Elijah Wood, Ian McKellen, Orlando Bloom",
                false,
                "https://upload.wikimedia.org/wikipedia/en/8/8a/The_Lord_of_the_Rings_The_Fellowship_of_the_Ring_%282001%29.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "7",
                "Your Name.",
                8.4,
                "PG",
                "1h 46min",
                "Animation, Drama, Fantasy",
                "7 April 2017 (USA)",
                "Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?",
                "Makoto Shinkai",
                "Makoto Shinkai",
                "Ryûnosuke Kamiki, Mone Kamishiraishi, Ryô Narita",
                false,
                "https://cdn.cinematerial.com/p/297x/kaynoyji/kimi-no-na-wa-japanese-movie-poster-md.jpg?v=1478802657"
            )
        )
        shows.add(
            ShowEntity(
                "8",
                "The Lord of the Rings: The Two Towers",
                8.7,
                "PG-13",
                "2h 59min",
                "Action, Adventure, Drama",
                "18 December 2002 (USA)",
                "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron's new ally, Saruman, and his hordes of Isengard.",
                "Peter Jackson",
                "J.R.R. Tolkien, Fran Walsh",
                "Elijah Wood, Ian McKellen, Viggo Mortensen",
                false,
                "https://upload.wikimedia.org/wikipedia/en/d/d0/Lord_of_the_Rings_-_The_Two_Towers_%282002%29.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "9",
                "Star Wars: Episode V - The Empire Strikes Back",
                8.7,
                "PG",
                "2h 4min",
                "Action, Adventure, Fantasy",
                "20 June 1980 (USA)",
                "After the Rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.",
                "Irvin Kershner",
                "Leigh Brackett, Lawrence Kasdan",
                "Mark Hamill, Harrison Ford, Carrie Fisher",
                false,
                "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
            )
        )
        shows.add(
            ShowEntity(
                "10",
                "The Matrix",
                8.7,
                "R",
                "2h 16min",
                "Action, Sci-Fi",
                "31 March 1999 (USA)",
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
                "Lana Wachowski, Lilly Wachowski",
                "Lilly Wachowski, Lana Wachowski",
                "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",
                false,
                "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"
            )
        )

        return shows
    }

    fun generateDummyTv(): List<TvShowEntity> {

        val shows = ArrayList<TvShowEntity>()

        shows.add(
            TvShowEntity(
                "101",
                "WandaVision",
                8.1,
                "TV-PG",
                "5h 50min",
                "Action, Comedy, Drama",
                "TV Mini-Series (2021)",
                "Blends the style of classic sitcoms with the MCU, in which Wanda Maximoff and Vision - two super-powered beings living their ideal suburban lives - begin to suspect that everything is not as it seems.",
                "Jac Schaeffer",
                "-",
                "Elizabeth Olsen, Paul Bettany, Kathryn Hahn",
                false,
                "https://i.pinimg.com/originals/73/38/24/73382422a4ffbca13387134140564bae.jpg"
            )
        )
        shows.add(
            TvShowEntity(
                "102",
                "Jujutsu Kaisen",
                8.7,
                "TV-MA",
                "24min",
                "Animation, Action, Adventure",
                "TV Series (2020-)",
                "A boy swallows a cursed talisman - the finger of a demon - and becomes cursed himself. He enters a shaman's school to be able to locate the demon's other body parts and thus exorcise himself.",
                "-",
                "-",
                "Junya Enoki, Yûichi Nakamura, Yuma Uchida",
                false,
                "https://static.wikia.nocookie.net/jujutsu-kaisen/images/8/88/Anime_Key_Visual_2.png/revision/latest?cb=20201212034001"
            )
        )
        shows.add(
            TvShowEntity(
                "103",
                "Fate/stay night: Unlimited Blade Works",
                8.0,
                "TV-14",
                "24min",
                "Animation, Action, Fantasy",
                "TV Series (2014-2015)",
                "A group of seven mages gets chosen to become masters of seven classes of heroic spirits, in order to fight and win the Holy Grail.",
                "-",
                "-",
                "Mela Lee, Bryce Papenbrook, Noriaki Sugiyama",
                false,
                "https://m.media-amazon.com/images/M/MV5BOTg5ZjI5ZTAtOWE2OS00MjY4LWI4ZDQtMzEzMDY4MTgzYWJlXkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_UY1200_CR106,0,630,1200_AL_.jpg"
            )
        )
        shows.add(
            TvShowEntity(
                "104",
                "Attack on Titan",
                8.9,
                "TV-MA",
                "24min",
                "Animation, Action, Adventure",
                "TV Series (2013-)",
                "After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.",
                "-",
                "Hajime Isayama",
                "Yûki Kaji, Marina Inoue, Josh Grelle",
                false,
                "https://upload.wikimedia.org/wikipedia/en/9/9a/Attack_on_Titan_The_Final_Season_Key_Visual_2.png"
            )
        )
        shows.add(
            TvShowEntity(
                "105",
                "Demon Slayer: Kimetsu No Yaiba ",
                8.7,
                "TV-MA",
                "25min",
                "Animation, Action, Fantasy",
                "TV Series (2019-)",
                "A family is attacked by demons and only two members survive - Tanjiro and his sister Nezuko, who is turning into a demon slowly. Tanjiro sets out to become a demon slayer to avenge his family and cure his sister.",
                "-",
                "-",
                "Natsuki Hanae, Zach Aguilar, Abby Trott",
                false,
                "https://m.media-amazon.com/images/M/MV5BZjZjNzI5MDctY2Y4YS00NmM4LTljMmItZTFkOTExNGI3ODRhXkEyXkFqcGdeQXVyNjc3MjQzNTI@._V1_UY1200_CR115,0,630,1200_AL_.jpg"
            )
        )
        shows.add(
            TvShowEntity(
                "106",
                "Chernobyl",
                9.4,
                "TV-MA",
                "5h 30min",
                "Drama, History, Trailer",
                "TV Mini-Series (2019)",
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "Craig Mazin",
                "-",
                "Jessie Buckley, Jared Harris, Stellan Skarsgård",
                false,
                "https://upload.wikimedia.org/wikipedia/id/a/a7/Chernobyl_2019_Miniseries.jpg"
            )
        )
        shows.add(
            TvShowEntity(
                "107",
                "Game of Thrones",
                9.3,
                "TV-MA",
                "57min",
                "Action, Adventure, Drama",
                "TV Series (2011-2019)",
                "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.",
                "David Benioff, D.B. Weiss",
                "-",
                "Emilia Clarke, Peter Dinklage, Kit Harington",
                false,
                "https://cdn.europosters.eu/image/750/posters/game-of-thrones-daenerys-for-the-throne-i72507.jpg"
            )
        )
        shows.add(
            TvShowEntity(
                "108",
                "Rick and Morty",
                9.2,
                "TV-MA",
                "23min",
                "Animation, Adventure, Comedy",
                "TV Series (2013-)",
                "An animated series that follows the exploits of a super scientist and his not-so-bright grandson.",
                "Dan Harmon, Justin Roiland",
                "-",
                "Justin Roiland, Chris Parnell, Spencer Grammer",
                false,
                "https://m.media-amazon.com/images/M/MV5BZjRjOTFkOTktZWUzMi00YzMyLThkMmYtMjEwNmQyNzliYTNmXkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1_.jpg"
            )
        )
        shows.add(
            TvShowEntity(
                "109",
                "Fullmetal Alchemist: Brotherhood",
                9.1,
                "TV-14",
                "24min",
                "Animation, Action, Adventure",
                "TV Series (2009-2012)",
                "Two brothers search for a Philosopher's Stone after an attempt to revive their deceased mother goes awry and leaves them in damaged physical forms.",
                "Hiromu Arakawa",
                "-",
                "Kent Williams, Iemasa Kayumi, Vic Mignogna",
                false,
                "https://m.media-amazon.com/images/M/MV5BZmEzN2YzOTItMDI5MS00MGU4LWI1NWQtOTg5ZThhNGQwYTEzXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY1200_CR113,0,630,1200_AL_.jpg"
            )
        )
        shows.add(
            TvShowEntity(
                "110",
                "Death Note",
                9.0,
                "TV-14",
                "24min",
                "Animation, Crime, Drama",
                "TV Series (2006-2007)",
                "An intelligent high school student goes on a secret crusade to eliminate criminals from the world after discovering a notebook capable of killing anyone whose name is written into it.",
                "-",
                "-",
                "Mamoru Miyano, Brad Swaile, Vincent Tong",
                false,
                "https://static.wikia.nocookie.net/deathnote/images/7/76/DEATH_NOTE_anime.jpg/revision/latest/top-crop/width/360/height/450?cb=20170720215429"
            )
        )
        return shows
    }

    fun generateRemoteDummyShows(): List<FilmResponse> {
        val shows = ArrayList<FilmResponse>()
        shows.add(
            FilmResponse(
                "1",
                "The Godfather",
                9.2,
                "R",
                "2h 55min",
                "Crime, Drama",
                "24 March 1972 (USA)",
                "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.",
                "Francis Ford Coppola",
                "Mario Puzo, Francis Ford Coppola",
                "Marlon Brando, Al Pacino, James Caan",
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "2",
                "Demon Slayer: Kimetsu no Yaiba the Moview: Mugen Train",
                8.3,
                "R",
                "1h 57min",
                "Animation, Action, Adventure",
                "23 April 2021 (USA)",
                "After his family was brutally murdered and his sister turned into a demon, Tanjiro Kamado's journey as a demon slayer began. Tanjiro and his comrades embark on a new mission aboard the Mugen Train, on track to despair.",
                "Haruo Sotozaki",
                "Koyoharu Gotouge",
                "Natsuki Hanae, Akari Kitô, Yoshitsugu Matsuoka",
                "https://wallpapercave.com/wp/wp7836444.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "3",
                "The Shawshank Redemption",
                9.3,
                "R",
                "2h 22min",
                "Drama",
                "14 October 1994 (USA)",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "Frank Darabont",
                " Stephen King, Frank Darabont",
                "Tim Robbins, Morgan Freeman, Bob Gunton",
                "https://images-na.ssl-images-amazon.com/images/I/51KjbtEkoeL._AC_.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "4",
                "The Dark Knight",
                9.0,
                "PG-13",
                "2h 32min",
                "Action, Crime, Drama",
                "18 July 2008 (USA)",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                "Christopher Nolan",
                "Jonathan Nolan, Christopher Nolan",
                "Christian Bale, Heath Ledger, Aaron Eckhart",
                "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "5",
                "The Lord of the Rings: The Return of the King",
                8.9,
                "PG-13",
                "3h 21min",
                "Action, Adventure, Drama",
                "17 December 2003 (USA)",
                "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
                "Peter Jackson",
                "J.R.R. Tolkien, Fran Walsh",
                "Elijah Wood, Viggo Mortensen, Ian McKellen",
                "https://images-na.ssl-images-amazon.com/images/I/71X6YzwV0gL._AC_SL1024_.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "6",
                "The Lord of the Rings: The Fellowship of the Ring",
                8.8,
                "PG-13",
                "2h 58min",
                "Action, Adventure, Drama",
                "19 December 2001 (USA)",
                "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
                "Peter Jackson",
                "J.R.R. Tolkien, Fran Walsh",
                "Elijah Wood, Ian McKellen, Orlando Bloom",
                "https://upload.wikimedia.org/wikipedia/en/8/8a/The_Lord_of_the_Rings_The_Fellowship_of_the_Ring_%282001%29.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "7",
                "Your Name.",
                8.4,
                "PG",
                "1h 46min",
                "Animation, Drama, Fantasy",
                "7 April 2017 (USA)",
                "Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?",
                "Makoto Shinkai",
                "Makoto Shinkai",
                "Ryûnosuke Kamiki, Mone Kamishiraishi, Ryô Narita",
                "https://cdn.cinematerial.com/p/297x/kaynoyji/kimi-no-na-wa-japanese-movie-poster-md.jpg?v=1478802657"
            )
        )
        shows.add(
            FilmResponse(
                "8",
                "The Lord of the Rings: The Two Towers",
                8.7,
                "PG-13",
                "2h 59min",
                "Action, Adventure, Drama",
                "18 December 2002 (USA)",
                "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron's new ally, Saruman, and his hordes of Isengard.",
                "Peter Jackson",
                "J.R.R. Tolkien, Fran Walsh",
                "Elijah Wood, Ian McKellen, Viggo Mortensen",
                "https://upload.wikimedia.org/wikipedia/en/d/d0/Lord_of_the_Rings_-_The_Two_Towers_%282002%29.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "9",
                "Star Wars: Episode V - The Empire Strikes Back",
                8.7,
                "PG",
                "2h 4min",
                "Action, Adventure, Fantasy",
                "20 June 1980 (USA)",
                "After the Rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.",
                "Irvin Kershner",
                "Leigh Brackett, Lawrence Kasdan",
                "Mark Hamill, Harrison Ford, Carrie Fisher",
                "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
            )
        )
        shows.add(
            FilmResponse(
                "10",
                "The Matrix",
                8.7,
                "R",
                "2h 16min",
                "Action, Sci-Fi",
                "31 March 1999 (USA)",
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
                "Lana Wachowski, Lilly Wachowski",
                "Lilly Wachowski, Lana Wachowski",
                "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",
                "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"
            )
        )
        return shows
    }

    fun generateRemoteDummyTvShows(): List<TvResponse> {
        val shows = ArrayList<TvResponse>()
        shows.add(
            TvResponse(
                "101",
                "WandaVision",
                8.1,
                "TV-PG",
                "5h 50min",
                "Action, Comedy, Drama",
                "TV Mini-Series (2021)",
                "Blends the style of classic sitcoms with the MCU, in which Wanda Maximoff and Vision - two super-powered beings living their ideal suburban lives - begin to suspect that everything is not as it seems.",
                "Jac Schaeffer",
                "-",
                "Elizabeth Olsen, Paul Bettany, Kathryn Hahn",
                "https://i.pinimg.com/originals/73/38/24/73382422a4ffbca13387134140564bae.jpg"
            )
        )
        shows.add(
            TvResponse(
                "102",
                "Jujutsu Kaisen",
                8.7,
                "TV-MA",
                "24min",
                "Animation, Action, Adventure",
                "TV Series (2020-)",
                "A boy swallows a cursed talisman - the finger of a demon - and becomes cursed himself. He enters a shaman's school to be able to locate the demon's other body parts and thus exorcise himself.",
                "-",
                "-",
                "Junya Enoki, Yûichi Nakamura, Yuma Uchida",
                "https://static.wikia.nocookie.net/jujutsu-kaisen/images/8/88/Anime_Key_Visual_2.png/revision/latest?cb=20201212034001"
            )
        )
        shows.add(
            TvResponse(
                "103",
                "Fate/stay night: Unlimited Blade Works",
                8.0,
                "TV-14",
                "24min",
                "Animation, Action, Fantasy",
                "TV Series (2014-2015)",
                "A group of seven mages gets chosen to become masters of seven classes of heroic spirits, in order to fight and win the Holy Grail.",
                "-",
                "-",
                "Mela Lee, Bryce Papenbrook, Noriaki Sugiyama",
                "https://m.media-amazon.com/images/M/MV5BOTg5ZjI5ZTAtOWE2OS00MjY4LWI4ZDQtMzEzMDY4MTgzYWJlXkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_UY1200_CR106,0,630,1200_AL_.jpg"
            )
        )
        shows.add(
            TvResponse(
                "104",
                "Attack on Titan",
                8.9,
                "TV-MA",
                "24min",
                "Animation, Action, Adventure",
                "TV Series (2013-)",
                "After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.",
                "-",
                "Hajime Isayama",
                "Yûki Kaji, Marina Inoue, Josh Grelle",
                "https://upload.wikimedia.org/wikipedia/en/9/9a/Attack_on_Titan_The_Final_Season_Key_Visual_2.png"
            )
        )
        shows.add(
            TvResponse(
                "105",
                "Demon Slayer: Kimetsu No Yaiba ",
                8.7,
                "TV-MA",
                "25min",
                "Animation, Action, Fantasy",
                "TV Series (2019-)",
                "A family is attacked by demons and only two members survive - Tanjiro and his sister Nezuko, who is turning into a demon slowly. Tanjiro sets out to become a demon slayer to avenge his family and cure his sister.",
                "-",
                "-",
                "Natsuki Hanae, Zach Aguilar, Abby Trott",
                "https://m.media-amazon.com/images/M/MV5BZjZjNzI5MDctY2Y4YS00NmM4LTljMmItZTFkOTExNGI3ODRhXkEyXkFqcGdeQXVyNjc3MjQzNTI@._V1_UY1200_CR115,0,630,1200_AL_.jpg"
            )
        )
        shows.add(
            TvResponse(
                "106",
                "Chernobyl",
                9.4,
                "TV-MA",
                "5h 30min",
                "Drama, History, Trailer",
                "TV Mini-Series (2019)",
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "Craig Mazin",
                "-",
                "Jessie Buckley, Jared Harris, Stellan Skarsgård",
                "https://upload.wikimedia.org/wikipedia/id/a/a7/Chernobyl_2019_Miniseries.jpg"
            )
        )
        shows.add(
            TvResponse(
                "107",
                "Game of Thrones",
                9.3,
                "TV-MA",
                "57min",
                "Action, Adventure, Drama",
                "TV Series (2011-2019)",
                "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.",
                "David Benioff, D.B. Weiss",
                "-",
                "Emilia Clarke, Peter Dinklage, Kit Harington",
                "https://cdn.europosters.eu/image/750/posters/game-of-thrones-daenerys-for-the-throne-i72507.jpg"
            )
        )
        shows.add(
            TvResponse(
                "108",
                "Rick and Morty",
                9.2,
                "TV-MA",
                "23min",
                "Animation, Adventure, Comedy",
                "TV Series (2013-)",
                "An animated series that follows the exploits of a super scientist and his not-so-bright grandson.",
                "Dan Harmon, Justin Roiland",
                "-",
                "Justin Roiland, Chris Parnell, Spencer Grammer",
                "https://m.media-amazon.com/images/M/MV5BZjRjOTFkOTktZWUzMi00YzMyLThkMmYtMjEwNmQyNzliYTNmXkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1_.jpg"
            )
        )
        shows.add(
            TvResponse(
                "109",
                "Fullmetal Alchemist: Brotherhood",
                9.1,
                "TV-14",
                "24min",
                "Animation, Action, Adventure",
                "TV Series (2009-2012)",
                "Two brothers search for a Philosopher's Stone after an attempt to revive their deceased mother goes awry and leaves them in damaged physical forms.",
                "Hiromu Arakawa",
                "-",
                "Kent Williams, Iemasa Kayumi, Vic Mignogna",
                "https://m.media-amazon.com/images/M/MV5BZmEzN2YzOTItMDI5MS00MGU4LWI1NWQtOTg5ZThhNGQwYTEzXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY1200_CR113,0,630,1200_AL_.jpg"
            )
        )
        shows.add(
            TvResponse(
                "110",
                "Death Note",
                9.0,
                "TV-14",
                "24min",
                "Animation, Crime, Drama",
                "TV Series (2006-2007)",
                "An intelligent high school student goes on a secret crusade to eliminate criminals from the world after discovering a notebook capable of killing anyone whose name is written into it.",
                "-",
                "-",
                "Mamoru Miyano, Brad Swaile, Vincent Tong",
                "https://static.wikia.nocookie.net/deathnote/images/7/76/DEATH_NOTE_anime.jpg/revision/latest/top-crop/width/360/height/450?cb=20170720215429"
            )
        )
        return shows
    }

    fun generateDummyDetailFilm(film: ShowEntity, favorited: Boolean): ShowEntity {
        film.favorited = favorited
        return film
    }

    fun generateDummyDetaiTv(tv: TvShowEntity, favorited: Boolean): TvShowEntity {
        tv.favorited = favorited
        return tv
    }
}