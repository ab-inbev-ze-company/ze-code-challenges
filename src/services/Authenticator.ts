import jwt from "jsonwebtoken";
import dotenv from "dotenv";
import { USER_ROLES } from "../models/User";

dotenv.config();

export interface ITokenPayload {
    id: string;
    role: USER_ROLES
}

export class Authenticator {
    generateToken = (payload: ITokenPayload): string => {
        const token = jwt.sign(
            payload,
            process.env.JWT_KEY,
            {
                expiresIn: process.env.JWT_EXPIRES_IN
            }
        );
        return token;
    }

    getTokenPayload = (token: string): ITokenPayload | null => {
        try {
            const payload = jwt.verify(
                token,
                process.env.JWT_KEY
            );
            return payload as ITokenPayload;
        } catch (error) {
            return null;
        }
    }
}