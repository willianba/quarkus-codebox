package org.codebox.resource;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codebox.dto.Condos;

public class Main {

    public static void main(String[] args) {
        ScoreCondo scoreCondo = new ScoreCondo(23,234,43,
                543,76,87,34,
                65,65,3,4);

        System.out.println("Score do condo: " + scoreCondo.CalculateScore());

    }
}
