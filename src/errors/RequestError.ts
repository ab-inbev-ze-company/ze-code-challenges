import { BaseError } from "./BaseError";

export class RequestError extends BaseError {
    constructor(
        message: string = "Invalid request"
    ) {
        super(400, message)
    }
}