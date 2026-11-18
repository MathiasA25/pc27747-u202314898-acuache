package com.campuslab.platform.u202314898.shared.domain.model;

public sealed interface Result<T> permits Result.Success, Result.Failure {

    record Success<T>(T value) implements Result<T> {
    }

    record Failure<T>(String message, boolean conflict) implements Result<T> {
    }

    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    static <T> Result<T> failure(String message) {
        return new Failure<>(message, false);
    }

    static <T> Result<T> conflict(String message) {
        return new Failure<>(message, true);
    }
}
