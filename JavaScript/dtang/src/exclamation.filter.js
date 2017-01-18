export function ExclamationFilter () {
    return (input, size = 1) => {
        if (typeof input !== 'string') return '';
        return input + '!'.repeat(size);
    }
}