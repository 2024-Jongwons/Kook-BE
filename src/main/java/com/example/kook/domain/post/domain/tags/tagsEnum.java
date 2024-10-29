package com.example.kook.domain.post.domain.tags;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum tagsEnum {
    Kimchi("김치"),
    Spicy("매운맛"),
    Buldak("불닭"),
    Vegetarian("채식주의자"),
    Chicken("치킨"),
    Mukbang("먹방"),
    Cooking("요리");

    private final String tags;
}
