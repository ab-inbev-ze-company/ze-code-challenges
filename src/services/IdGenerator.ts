import { v4 } from 'uuid';

export class IdGenerator {
    public generate = (): string => v4();
}