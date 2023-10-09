package com.example.amindesmond_comp228lab4;





import java.sql.Date;


public class PlayerAndGame


{
    private int player_game_id;
    private String game_id;
    private int player_id;
    private Date playing_date;

    public PlayerAndGame(){

    }

    public int getPlayer_game_id() {
        return player_game_id;
    }

    public void setPlayer_game_id(int player_game_id) {
        this.player_game_id = player_game_id;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public Date getPlaying_date() {
        return playing_date;
    }

    public void setPlaying_date(Date playing_date) {
        this.playing_date = playing_date;
    }
}
