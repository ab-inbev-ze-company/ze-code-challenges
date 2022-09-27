import bycript from 'bcryptjs';

export class HashManager {
    public hash = async (plainText: string) => {
        const rounds = Number(process.env.BCRYPT_SALT_ROUNDS);
        const salt = await bycript.genSalt(rounds);
        const hash = await bycript.hash(plainText, salt);

        return hash;
    }

    public compare = async (plainText: string, hasht: string) => {
        return bycript.compare(plainText, hasht);
    }
}