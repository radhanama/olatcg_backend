package br.com.olatcg_backend.util;

import br.com.olatcg_backend.enumerator.ErrorEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

@Component
public class ProcessingHandlerUtils {

    @Value("${config.olatcg.timeout}")
    private Long timeout;

    public DeferredResult<ResponseEntity<?>> respondAccordingProccessTime(Object timeoutResponse, Function<Object, Object> action, Object actionParameter) throws CustomException {
        try {
            DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>(timeout);
            deferredResult.onTimeout(() ->
                    deferredResult.setResult(
                            ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                                    .body(timeoutResponse)
                    ));

            ForkJoinPool.commonPool().submit(() -> {
                Object response = new Object();
                try{
                    response = action.apply(actionParameter);
                } catch (Exception e){
                    // TODO: tratar erros
                }
                deferredResult.setResult(ResponseEntity.status(HttpStatus.CREATED).body(response));
            });

            return deferredResult;
        } catch (Exception e) {
            throw new CustomException(ErrorEnum.PROCESSING_HANDLER_FAILED);
        }
    }
}
