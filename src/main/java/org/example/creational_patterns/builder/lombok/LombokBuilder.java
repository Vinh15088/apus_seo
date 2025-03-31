package org.example.creational_patterns.builder.lombok;

import lombok.Builder;

@Builder
public class LombokBuilder {
    private String field1;
    private String field2;
    private String field3;
    private int field4;

    @Override
    public String toString() {
        return "LombokBuilder{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4=" + field4 +
                '}';
    }

    public static void main(String[] args) {
        LombokBuilder builder = LombokBuilder.builder()
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .build();

        System.out.println(builder.toString());
    }
}
