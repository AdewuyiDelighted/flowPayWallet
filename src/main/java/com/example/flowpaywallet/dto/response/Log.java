package com.example.flowpaywallet.dto.response;

import lombok.Data;

@Data
public class Log {
    private int start_time;
    private int time_spent;
    private int attempts;
    private int errors;
    private boolean success;
    private boolean mobile;
}

