package pl.sagi.districts;

import org.bukkit.entity.Player;

import java.util.*;

public class DistrictManager {

    private final Map<Integer, List<UUID>> districts = new HashMap<>();

    public void createDistrict(int id) {
        districts.putIfAbsent(id, new ArrayList<>());
    }

    public boolean addPlayer(int id, Player player) {
        removePlayer(player);
        if (!districts.containsKey(id)) return false;
        districts.get(id).add(player.getUniqueId());
        return true;
    }

    public void removePlayer(Player player) {
        districts.values().forEach(list -> list.remove(player.getUniqueId()));
    }

    public int getDistrict(Player player) {
        for (var e : districts.entrySet()) {
            if (e.getValue().contains(player.getUniqueId())) return e.getKey();
        }
        return -1;
    }

    public Map<Integer, List<UUID>> getDistricts() {
        return districts;
    }
