package com.example.demo.service;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;


@Service
public class RouteServiceImpl implements RouteService{
    private static  final String YES = "yes";
    private static  final String NO = "no";

    private HashMap<Pair<String,String>, String> routes = establishRoutes();

    public String getRoute(String from, String to) {
        return routes.getOrDefault(new Pair(from,to), NO);

    }

    private HashMap<Pair<String,String>, String> establishRoutes() {
        HashMap<Pair<String,String>, String> routeHash = new HashMap<>();
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))) {
            stream.forEach(line->addRoute(routeHash, line));
        }
        catch (Exception e) {
        }
        return routeHash;
    }

    private void addRoute(HashMap<Pair<String,String>, String> routeHash, String path) {
        String[] route = path.split("\\,");
        routeHash.put(new Pair(route[0].trim(), route[1].trim()), YES);
    }
}
