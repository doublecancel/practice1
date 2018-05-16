package com.example.learn.handlers;

import com.example.learn.common.FluxResponse;
import com.example.learn.core.ExceptionCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2018/2/1.
 */
@Component
public class ErrorHandler {

    public static final String NOT_FOUND_MESSAGE = "找不到匹配的路径";
    /**
     * 路径404
     * @param request
     * @return
     */
    public static Mono<ServerResponse> notFound (ServerRequest request){
        return      ServerResponse.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(FluxResponse.error(HttpStatus.NOT_FOUND.value(), NOT_FOUND_MESSAGE)), FluxResponse.class);
    }

    public static Mono<ServerResponse> formatException (Throwable t){
        t.printStackTrace();
        return Mono.just(t).transform(a -> transform(a))
                .flatMap(a ->
                    ServerResponse.ok().body(Mono.just(a), FluxResponse.class)
                );
    }

    public static Mono<FluxResponse> transform(Mono<Throwable> mono){
        return mono.flatMap(a -> {
                    int code = ExceptionCodeEnum.getCode(a.getClass())                    ;
                    return Mono.just(FluxResponse.error(code, a.getMessage()));
                }
        );
    }
}
