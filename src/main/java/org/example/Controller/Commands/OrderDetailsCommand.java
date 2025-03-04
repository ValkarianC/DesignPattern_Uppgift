package org.example.Controller.Commands;

import java.util.HashMap;

public interface OrderDetailsCommand {
    String process(HashMap<String, String> orderDetails);
}
