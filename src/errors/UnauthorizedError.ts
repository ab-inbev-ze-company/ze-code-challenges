import { BaseError } from "./BaseError";

export class UnauthorizedError extends BaseError {
    constructor(
        message: string = "Invalid credentials"
    ) {
        super(401, message)
    }
}