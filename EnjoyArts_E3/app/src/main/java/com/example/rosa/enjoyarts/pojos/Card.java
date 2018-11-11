package com.example.rosa.enjoyarts.pojos;

public class Card {


        String artist, title, location;
        int year;

        public Card(String artist, String title, int year, String location ) {
            this.artist = artist;
            this.title = title;
            this.year = year;
            this.location = location;

        }

    public Card(int sinValorInt, String artist, String title, String year, String location) {
    }

    public String getArtist() {

            return artist;
        }

        public void setArtist(String artist) {

            this.artist = artist;
        }

        public String getTitle() {

            return title;
        }

        public void setTitle(String title) {

            this.title = title;
        }
        public int getYear() {

            return year;

        }

        public void setYear(int year) {

            this.year = year;
        }

        public String getLocation() {

            return location;
        }

        public void setLocation(String location) {

            this.location = location;
        }


    }






