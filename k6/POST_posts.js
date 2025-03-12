// GET
import http from "k6/http";
import { sleep } from "k6";

export const options = {
    vus: 100, // 가상 사용자 수
    duration: "10s", // 테스트 시간
};

export default function () {
    const payload = JSON.stringify({
        title: 'title',
        body: 'body',
    });
    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };
    http.post("http://localhost:8080", payload, params);
    sleep(1)
}