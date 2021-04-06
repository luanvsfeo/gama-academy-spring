package com.gama.ecommerce.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class ResponseExceptions {
    private Integer status;
    private OffsetDateTime data;
    private String message;
    private List<Body> bodys;

    public static class Body {
        private String nome;
        private String mensagem;

        public Body(String nome, String mensagem) {
            this.setNome(nome);
            this.setMensagem(mensagem);
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }

    public ResponseExceptions(Integer status, OffsetDateTime data, String message, List<Body> bodys) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.bodys = bodys;
    }

    public ResponseExceptions() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public void setData(OffsetDateTime data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Body> getBodys() {
        return bodys;
    }

    public void setBodys(List<Body> bodys) {
        this.bodys = bodys;
    }
}
