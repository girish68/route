package com.example.demo.controller;

import com.example.demo.service.RouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Request;


@RestController
@RequestMapping("/connected")
@Api(value="Route Service", description="Route Service between cities")
public class RouteController
{
    @Autowired
    RouteService cityService;


    @ApiOperation(value = "Confirms the route between cities passed as parameters", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieves the route")
    }
    )
    @RequestMapping(value="", method = RequestMethod.GET)
    public String getRoute(@RequestParam("origin") String origin, @RequestParam("destination") String destination)
    {
        return cityService.getRoute(origin, destination);
    }
}
