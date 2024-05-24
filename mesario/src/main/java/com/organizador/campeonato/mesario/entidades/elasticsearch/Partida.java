package com.organizador.campeonato.mesario.entidades.elasticsearch;


import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * Entidade que representa uma partida.
 *
 * @author andersonvieira
 */
@TypeAlias("partida")
@Document(indexName = "partida-5", createIndex = false)
public class Partida {

    @Id
    private String id;

    @Field(type= FieldType.Date, name = "data", pattern="dd.MM.uuuu")
    private LocalDate data;

    @Field(type = FieldType.Long, name = "campeonato_id")
    private Long campeonatoId;

    @Field(type = FieldType.Long, name = "local_id")
    private Long localId;

    @Field(type = FieldType.Text, name = "observacao")
    private String observacao;

    @Field(type = FieldType.Long, name = "time_mandante_id")
    private Long timeMandanteId;

    @Field(type = FieldType.Long, name = "time_visitante_id")
    private Long timeVisitanteId;

    @Field(type = FieldType.Integer, name = "gols_mandante")
    private Integer golsMandante;

    @Field(type = FieldType.Integer, name = "gols_visitante")
    private Integer golsVisitante;

    @Field(type = FieldType.Integer, name = "rodada")
    private Integer rodada;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getCampeonatoId() {
        return campeonatoId;
    }

    public void setCampeonatoId(Long campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

    public Long getLocalId() {
        return this.localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getTimeMandanteId() {
        return this.timeMandanteId;
    }

    public void setTimeMandanteId(Long timeMandanteId) {
        this.timeMandanteId = timeMandanteId;
    }

    public Long getTimeVisitanteId() {
        return this.timeVisitanteId;
    }

    public void setTimeVisitanteId(Long timeVisitanteId) {
        this.timeVisitanteId = timeVisitanteId;
    }

    public Integer getGolsMandante() {
        return this.golsMandante;
    }

    public void setGolsMandante(Integer golsMandante) {
        this.golsMandante = golsMandante;
    }

    public Integer getGolsVisitante() {
        return this.golsVisitante;
    }

    public void setGolsVisitante(Integer golsVisitante) {
        this.golsVisitante = golsVisitante;
    }

    public Integer getRodada() {
        return this.rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Partida that) {
            return Objects.equals(this.id, that.id) &&
                    Objects.equals(this.data, that.data) &&
                    Objects.equals(this.campeonatoId, that.campeonatoId) &&
                    Objects.equals(this.localId, that.localId) &&
                    Objects.equals(this.observacao, that.observacao) &&
                    Objects.equals(this.timeMandanteId, that.timeMandanteId) &&
                    Objects.equals(this.timeVisitanteId, that.timeVisitanteId) &&
                    Objects.equals(this.golsMandante, that.golsMandante) &&
                    Objects.equals(this.golsVisitante, that.golsVisitante) &&
                    Objects.equals(this.rodada, that.rodada);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

}
