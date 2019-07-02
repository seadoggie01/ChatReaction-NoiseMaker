package com.seadoggie;

import me.clip.chatreaction.events.ReactionStartEvent;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getServer;

public class NoiseMakerListener implements Listener {

    final private NoiseMaker instance;

    // Get the instance of the plugin from "Main" when this class is created
    NoiseMakerListener(NoiseMaker instance){
        this.instance = instance;
    }



    @EventHandler
    //When the me.clip.chatreaction.ReactionStartEvent event is received
    void NoiseMakingEventHandler(ReactionStartEvent event){
        // Get the config from ChatReaction... nobody wants to setup another config
        FileConfiguration chatConfig = getServer().getPluginManager().getPlugin("ChatReaction").getConfig();
        // Get the octave from the config
        int octave = chatConfig.getInt("Music.Octave");
        // Get the tone from the config
        String unparsedTone = chatConfig.getString("Music.Tone");
        // A tone
        Note.Tone tone;
        // Try to parse the value from the config
        try {
            tone = Note.Tone.valueOf(unparsedTone);
        }catch (Exception ex){
            // Default to E if there's an error
            tone = Note.Tone.E;
        }
        // For each player online
        for(Player player: instance.getServer().getOnlinePlayers()){
            // Play the note at the player's location
            player.playNote(player.getLocation(), Instrument.PLING, Note.flat(octave, Note.Tone.E));
        }
    }

}
