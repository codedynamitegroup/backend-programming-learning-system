insert into qtype_code_questions
values ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994221', 'dsl', 'pro state','input','output','CREATING',null, 'constraints');

insert into code_questions_update_outbox(id, saga_id, created_at, type, payload, outbox_status, saga_status, copy_state, version)
values ('8904808e-286f-449b-9b56-b63ba8351cf2', '15a497c1-0f4b-4eff-b9f4-c402c8c07afa', current_timestamp, 'CODE_QUESTIONS_UPDATE_SAGA',
        '{"id": "d215b5f8-0249-4dc5-89a3-51fd148cfb17", "questionId": "b6484e21-6937-489c-b031-b71767994221", "problemStatement": "pro statement", "inputFormat": "input", "outputFormat": "output", "copyState": "CREATING", "constraints": "constraints"}',
        'STARTED', 'STARTED', 'CREATING', 0);
