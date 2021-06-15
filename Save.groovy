import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'Save'
    request {
        urlPath('/save')
        method 'POST'
        headers {
            contentType('multipart/form-data; charset=UTF-8')
        }

        multipart(
                "field1": $(producer("test-field1"), consumer(anyNonBlankString())),
                "field2": $(producer("test-field2"), consumer(anyNonBlankString())),
                "field3": $(producer("test-field3"), consumer(anyNonBlankString())),
                "files[path/to/file]": named(
                        "name": $(consumer(nonEmpty()), producer("archive.zip")),
                        "content": $(consumer(nonEmpty()), producer("content")))
        )
    }

    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body(
                [
                        "status": $(consumer("success"), producer(anyNonBlankString()))
                ]
        )
    }
}