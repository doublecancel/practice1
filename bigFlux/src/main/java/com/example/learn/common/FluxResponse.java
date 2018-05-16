package com.example.learn.common;

import lombok.Data;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2018/1/31.
 */
@Data
public class FluxResponse {
    private int code;
    private Object data;
    private boolean success;

    public FluxResponse(int code, Object data, boolean success) {
        this.code = code;
        this.data = data;
        this.success = success;
    }

    public static FluxResponse success(){
        return new FluxResponse(200, null, true);
    }

    public static FluxResponse error(){
        return new FluxResponse(500, null, false);
    }

    public static FluxResponse error(int code, Object data){
        return new FluxResponse(code, data, false);
    }

    public static FluxResponse success(Object data){
        return new FluxResponse(200, data, true);
    }

    public static FluxResponse error(Object data){
        return new FluxResponse(500, data, false);
    }

    public static Mono<ServerResponse> obj2Response(Mono m){
        return m.flatMap(a ->
            ServerResponse.ok().body(Mono.just(FluxResponse.success(a)), FluxResponse.class)
        );
    }
}
