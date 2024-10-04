
    document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("btn-save").addEventListener("click", function () {
        const title = document.getElementById("title").value;
        const author = document.getElementById("author").value;
        const content = document.getElementById("content").value;
        const eventDate = document.getElementById("eventDate").value; // 날짜 입력 값
        const eventTime = document.getElementById("eventTime").value; // 시간 입력 값
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

        // 데이터 객체 생성
        const postData = {
            title: title,
            author: author,
            content: content,
            password: password,
            confirmPassword: confirmPassword
        };

        fetch("/posts/save", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                title: title,
                author: author,
                content: content,
                password: password,
                confirmPassword: confirmPassword,
                eventDateTime: `${eventDate}T${eventTime}` // 날짜와 시간을 결합한 ISO 형식
            })
        }).then(response => {
            if (response.ok) {
                alert("게시글이 등록되었습니다.");
                window.location.href = "/";
            } else {
                alert("게시글 등록 실패. 다시 시도해주세요.");
            }
        })
            .catch((error) => {
                console.error('Error:', error);
            });
    })
})
    document.addEventListener('DOMContentLoaded', function() {
        document.getElementById("btn-update").addEventListener("click", function () {
            const id = document.getElementById("id").value;
            const title = document.getElementById("title").value;
            const content = document.getElementById("content").value;
            const eventDate = document.getElementById("eventDate").value;
            const eventTime = document.getElementById("eventTime").value;

            // 데이터 객체 생성
            const postData = {
                id: id,
                title: title,
                content: content,
                eventDate: eventDate,
                eventTime: eventTime
            };
            if (updateButton) {
                updateButton.addEventListener("click", function () {
                    // 클릭 시 동작할 코드
                });
            } else {
                console.error("Update button not found!");
            }

            fetch(`/posts/update/${id}`, {
                method: "PUT", // HTTP PUT 메서드 사용
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(postData)
            }).then(response => {
                if (response.ok) {
                    alert("게시글이 수정되었습니다.");
                    window.location.href = "/";
                } else {
                    alert("게시글 수정 실패. 다시 시도해주세요.");
                }
            })
                .catch((error) => {
                    console.error('Error:', error);
                });
        });

        document.getElementById("btn-delete").addEventListener("click", function () {
            const id = document.getElementById("id").value;

            fetch(`/posts/delete/${id}`, {
                method: "DELETE" // HTTP DELETE 메서드 사용
            }).then(response => {
                if (response.ok) {
                    alert("게시글이 삭제되었습니다.");
                    window.location.href = "/";
                } else {
                    alert("게시글 삭제 실패. 다시 시도해주세요.");
                }
            })
                .catch((error) => {
                    console.error('Error:', error);
                });
        });
    });
