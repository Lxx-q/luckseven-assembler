/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service.common.function;

/**
 *
 * @author king
 */
public interface TransferFunction<T, M> {

    public M transfer( T target );
    
}
